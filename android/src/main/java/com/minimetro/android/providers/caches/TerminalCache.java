package com.minimetro.android.providers.caches;

import android.database.Cursor;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.minimetro.Terminal;
import com.minimetro.android.providers.contracts.TerminalContract;
import com.minimetro.android.util.KitKatMatrixCursor;

import java.util.HashMap;
import java.util.List;

public class TerminalCache {
    private final HashMap<String, Terminal> terminals = Maps.newHashMap();

    public TerminalCache() {}

    public synchronized Cursor getTerminals() {
        KitKatMatrixCursor cursor = new KitKatMatrixCursor(TerminalContract.getColumnNames(TerminalContract.Terminal.CursorColumns.class));
        for(Terminal terminal : terminals.values()) {
            addRow(cursor, terminal);
        }

        return cursor;
    }

    public synchronized Cursor getTerminalById(long id) {
        Terminal terminal = Lists.newArrayList(terminals.values()).get((int) id);

        KitKatMatrixCursor cursor = new KitKatMatrixCursor(TerminalContract.getColumnNames(TerminalContract.Terminal.CursorColumns.class));
        addRow(cursor, terminal);

        return cursor;
    }

    public synchronized Cursor getTerminalByUuid(String uuid) {
        Terminal terminal = terminals.get(uuid);

        KitKatMatrixCursor cursor = new KitKatMatrixCursor(TerminalContract.getColumnNames(TerminalContract.Terminal.CursorColumns.class));
        addRow(cursor, terminal);

        return cursor;
    }

    public synchronized Cursor getUpgradesByTerminalId(long id) {
        Terminal terminal = Lists.newArrayList(terminals.values()).get((int) id);

        KitKatMatrixCursor cursor = new KitKatMatrixCursor(TerminalContract.getColumnNames(TerminalContract.Upgrade.CursorColumns.class));
        for(Terminal.Upgrade upgrade : terminal.getUpgrades()){
            addRow(cursor, terminal, upgrade);
        }

        return cursor;
    }

    public synchronized Cursor getUpgradesByTerminalUuid(String uuid) {
        Terminal terminal = terminals.get(uuid);

        KitKatMatrixCursor cursor = new KitKatMatrixCursor(TerminalContract.getColumnNames(TerminalContract.Upgrade.CursorColumns.class));
        for(Terminal.Upgrade upgrade : terminal.getUpgrades()){
            addRow(cursor, terminal, upgrade);
        }

        return cursor;
    }


    public void update() {

    }

    private synchronized void setTerminals(List<Terminal> terminals) {
        for(Terminal terminal : terminals) {
            this.terminals.put(terminal.getUuid().toString(), terminal);
        }
    }

    private void addRow(KitKatMatrixCursor cursor, Terminal terminal) {
        int terminalId = Lists.newArrayList(terminals).indexOf(terminal);

        TerminalContract.Terminal.CursorColumns columns = new TerminalContract.Terminal.CursorColumns();

        cursor.newRow()
                .add(columns.ID, terminalId)
                .add(columns.UUID, terminal.getUuid().toString())
                .add(columns.TYPE, terminal.getType());
    }

    private void addRow(KitKatMatrixCursor cursor, Terminal terminal, Terminal.Upgrade upgrade) {
        int terminalId = Lists.newArrayList(terminals).indexOf(terminal);
        int upgradeId = Lists.newArrayList(terminal.getUpgrades()).indexOf(upgrade);

        TerminalContract.Upgrade.CursorColumns columns = new TerminalContract.Upgrade.CursorColumns();

        cursor.newRow()
                .add(columns.TERMINAL_ID, terminalId)
                .add(columns.UPGRADE_ID, upgradeId)
                .add(columns.UPGRADE, upgrade);
    }
}
