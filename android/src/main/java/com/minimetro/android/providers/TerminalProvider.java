package com.minimetro.android.providers;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;

import com.minimetro.android.providers.caches.TerminalCache;
import com.minimetro.android.providers.contracts.TerminalContract;

import java.util.List;

public class TerminalProvider extends ContentProvider {
    private static final int TERMINALS_MATCH = 1000;
    private static final int TERMINALS_SPECIFIC_MATCH = 1001;
    private static final int UPGRADE_MATCH = 2000;

    private static final UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        uriMatcher.addURI(TerminalContract.AUTHORITY,
                TerminalContract.Terminal.DIRECTORY, TERMINALS_MATCH);

        uriMatcher.addURI(TerminalContract.AUTHORITY,
                TerminalContract.Terminal.DIRECTORY + "/#", TERMINALS_SPECIFIC_MATCH);

        uriMatcher.addURI(TerminalContract.AUTHORITY,
                TerminalContract.Terminal.DIRECTORY_BY_UUID + "/*", TERMINALS_SPECIFIC_MATCH);

        uriMatcher.addURI(TerminalContract.AUTHORITY,
                TerminalContract.Upgrade.DIRECTORY, UPGRADE_MATCH);

        uriMatcher.addURI(TerminalContract.AUTHORITY,
                TerminalContract.Terminal.DIRECTORY + "/#/" + TERMINALS_SPECIFIC_MATCH + "/#/" +
                        TerminalContract.Upgrade.DIRECTORY, UPGRADE_MATCH);

        uriMatcher.addURI(TerminalContract.AUTHORITY,
                TerminalContract.Terminal.DIRECTORY_BY_UUID + "/*/" + TERMINALS_SPECIFIC_MATCH + "/#/" +
                        TerminalContract.Upgrade.DIRECTORY, UPGRADE_MATCH);
    }

    private TerminalCache terminalCache;

    @Override
    public boolean onCreate() {
        terminalCache = new TerminalCache();
        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        int match = uriMatcher.match(uri);
        switch (match) {
            case TERMINALS_MATCH:
                return terminalCache.getTerminals();
            case TERMINALS_SPECIFIC_MATCH:
                try {
                    long id = Integer.parseInt(uri.getLastPathSegment());

                    return terminalCache.getTerminalById(id);
                } catch(NumberFormatException e) {
                    String uuid = uri.getLastPathSegment();

                    return terminalCache.getTerminalByUuid(uuid);
                }
            case UPGRADE_MATCH:
                List<String> segments = uri.getPathSegments();

                if(segments.contains(TerminalContract.Terminal.DIRECTORY)) {
                    long id = Integer.valueOf(uri.getPathSegments().get(
                            uri.getPathSegments().indexOf(TerminalContract.Terminal.DIRECTORY) + 1));

                    return terminalCache.getUpgradesByTerminalId(id);
                } else if(segments.contains(TerminalContract.Terminal.DIRECTORY_BY_UUID)) {
                    String uuid = uri.getPathSegments().get(
                            uri.getPathSegments().indexOf(TerminalContract.Terminal.DIRECTORY) + 1);

                    return terminalCache.getUpgradesByTerminalUuid(uuid);
                }
            default:
                return null;
        }
    }

    @Override
    public String getType(Uri uri) {
        int match = uriMatcher.match(uri);
        switch (match) {
            case TERMINALS_MATCH:
            case TERMINALS_SPECIFIC_MATCH:
                return TerminalContract.Terminal.MIME_TYPE;
            case UPGRADE_MATCH:
                return TerminalContract.Upgrade.MIME_TYPE;
            default:
                return "";
        }
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
