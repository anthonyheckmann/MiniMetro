package com.minimetro;

import junit.framework.TestCase;

import org.junit.Assert;

public class TerminalTest extends TestCase {
    private Terminal terminal;

    public void setUp() throws Exception {
        terminal = new Terminal();
    }

    public void testTerminalHasType() {
        Assert.assertNotNull(terminal.getType());
    }

    public void testTerminalHasUuid() {
        Assert.assertNotNull(terminal.getUuid());
    }
}
