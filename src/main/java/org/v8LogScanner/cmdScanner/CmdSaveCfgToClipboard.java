package org.v8LogScanner.cmdScanner;

import org.v8LogScanner.cmdAppl.CmdCommand;
import org.v8LogScanner.commonly.fsys;

public class CmdSaveCfgToClipboard implements CmdCommand {
    @Override
    public String getTip() {
        return "";
    }

    @Override
    public void execute() {
        fsys.copyToClipboard(V8LogScannerAppl.instance().logBuilder.getContent());
    }
}
