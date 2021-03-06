/////////////////////////////////////
//COMMAND PATTERN

package org.v8LogScanner.cmdScanner;

import org.v8LogScanner.cmdAppl.CmdCommand;
import org.v8LogScanner.rgx.RegExp;
import org.v8LogScanner.rgx.RegExp.EventTypes;

import java.util.List;

public class CmdAddLogEvent implements CmdCommand {

    public void execute() {

        V8LogScannerAppl appl = V8LogScannerAppl.instance();

        EventTypes[] events = EventTypes.values();
        String userInput = appl.getConsole().askInputFromList("Choose event to add:", events);
        if (userInput != null) {
            EventTypes event = (events[Integer.parseInt(userInput)]);
            List<RegExp> rgxs = appl.profile.getRgxList();
            if (event == EventTypes.ANY)
                rgxs.clear();
            else {
                for (RegExp regExp : rgxs)
                    if (regExp.getEventType() == EventTypes.ANY) {
                        rgxs.remove(regExp);
                        break; // avoid concurrent modification
                    }
            }
            rgxs.add(new RegExp(event));
        }
    }

    public String getTip() {
        V8LogScannerAppl appl = V8LogScannerAppl.instance();
        return appl.profile.getRgxList().toString();
    }
}
