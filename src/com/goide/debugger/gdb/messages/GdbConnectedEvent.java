package com.goide.debugger.gdb.messages;

import com.goide.debugger.gdb.gdbmi.GdbMiRecord;
import com.goide.debugger.gdb.gdbmi.GdbMiValue;
import com.goide.debugger.gdb.messages.annotations.GdbMiEvent;
import com.goide.debugger.gdb.messages.annotations.GdbMiField;

import java.util.Map;

/**
 * Event fired when GDB connects to a remote target.
 */
@SuppressWarnings("unused")
@GdbMiEvent(recordType = GdbMiRecord.Type.Immediate, className = "connected")
public class GdbConnectedEvent extends GdbEvent {
  /**
   * The execution address.
   */
  @SuppressWarnings("unused")
  @GdbMiField(name = "addr", valueType = GdbMiValue.Type.String,
              valueProcessor = "com.goide.debugger.gdb.messages.GdbMiMessageConverterUtils.hexStringToLong")
  public Long address;

  /**
   * The name of the function.
   */
  @SuppressWarnings("unused")
  @GdbMiField(name = "func", valueType = GdbMiValue.Type.String, valueProcessor =
    "com.goide.debugger.gdb.messages.GdbMiMessageConverterUtils.passThroughIfNotQQ")
  public String function;

  /**
   * The arguments to the function.
   */
  @SuppressWarnings("unused")
  @GdbMiField(name = "args", valueType = GdbMiValue.Type.List)
  public Map<String, String> arguments;
}
