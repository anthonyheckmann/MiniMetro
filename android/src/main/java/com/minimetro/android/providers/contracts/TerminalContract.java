package com.minimetro.android.providers.contracts;

import android.net.Uri;

import com.google.common.collect.Lists;

import java.lang.reflect.Field;
import java.util.List;

public class TerminalContract {
    public static final String AUTHORITY = "com.minimetro.android";
    public static final String BASE_URI = "content://" + AUTHORITY + "/";

    public static final class Terminal {
        public static final String DIRECTORY = "terminals";
        public static final String DIRECTORY_BY_UUID = "terminalsByUuid";
        public static final String MIME_TYPE = "vnd.minimetro.cursor/terminal";

        public static Uri getTerminalsUri() {
            return Uri.parse(BASE_URI + DIRECTORY);
        }

        public static Uri getTerminalUri(long id) {
            return Uri.parse(BASE_URI + DIRECTORY + "/" + String.valueOf(id));
        }

        public static Uri getTerminalUri(String uuid) {
            return Uri.parse(BASE_URI + DIRECTORY_BY_UUID + "/" + uuid);
        }

        public static final class CursorColumns {
            public static final String ID = "_id";
            public static final String UUID = "uuid";
            public static final String TYPE = "type";
        }
    }

    public static final class Upgrade {
        public static final String DIRECTORY = "upgrades";
        public static final String MIME_TYPE = "vnd.minimetro.cursor/upgrade";

        public static Uri getUpgradesUri() {
            return Uri.parse(BASE_URI + DIRECTORY);
        }

        public static Uri getUpgradesByTerminalUri(long id) {
            return Uri.parse(
                    Terminal.getTerminalUri(id) + "/"
                            + DIRECTORY);
        }

        public static final class CursorColumns {
            public static final String TERMINAL_ID = "terminal_id";
            public static final String UPGRADE_ID = "upgrade_id";
            public static final String UPGRADE = "upgrade";
        }
    }

    public static String[] getColumnNames(Class klass) {
        List<String> cols = Lists.newArrayList();

        Field[] fields = klass.getDeclaredFields();
        for (Field f : fields) {
            if (f.getType().isAssignableFrom(String.class)) {
                try {
                    cols.add((String)f.get(null));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        return cols.toArray(new String[] {});
    }
}
