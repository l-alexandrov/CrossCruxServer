package com.crosscrux.server.protocol.action;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ProtocolException;

public abstract class Action {
    public static final byte MOUSE_MOVE = 0;
    public static final byte MOUSE_CLICK = 1;
    public static final byte MOUSE_WHEEL = 2;
    public static final byte KEYBOARD = 3;
    public static final byte AUTHENTICATION = 4;
    public static final byte AUTHENTICATION_RESPONSE = 5;
    public static final byte SCREEN_CAPTURE_REQUEST = 6;
    public static final byte SCREEN_CAPTURE_RESPONSE = 7;
    public static final byte FILE_EXPLORE_REQUEST = 8;
    public static final byte FILE_EXPLORE_RESPONSE = 9;
    public static final byte COMBINATIONS = 10;
    public static final byte COMBINATION = 11;

    public Action() {
    }

    public static Action parse(DataInputStream dis) throws IOException {
        byte type = dis.readByte();
        switch(type) {
            case 0:
                return MouseMoveAction.parse(dis);
            case 1:
                return MouseClickAction.parse(dis);
            case 2:
                return MouseWheelAction.parse(dis);
            case 3:
                return KeyboardAction.parse(dis);
            case 4:
                return AuthenticationAction.parse(dis);
            case 5:
                return AuthenticationResponseAction.parse(dis);
            case 6:
                return ScreenCaptureRequestAction.parse(dis);
            case 7:
                return ScreenCaptureResponseAction.parse(dis);
            case 8:
                return FileExploreRequestAction.parse(dis);
            case 9:
                return FileExploreResponseAction.parse(dis);
            case 10:
                return Combinations.parse(dis);
            case 11:
                return Combination.parse(dis);
            default:
                throw new ProtocolException();
        }
    }

    public static Action parse(DataInputStream dis, byte type) throws IOException {
        switch(type) {
            case 0:
                return MouseMoveAction.parse(dis);
            case 1:
                return MouseClickAction.parse(dis);
            case 2:
                return MouseWheelAction.parse(dis);
            case 3:
                return KeyboardAction.parse(dis);
            case 4:
                return AuthenticationAction.parse(dis);
            case 5:
                return AuthenticationResponseAction.parse(dis);
            case 6:
                return ScreenCaptureRequestAction.parse(dis);
            case 7:
                return new ScreenCaptureResponseAction(new byte[0]);
            case 8:
                return FileExploreRequestAction.parse(dis);
            case 9:
                return FileExploreResponseAction.parse(dis);
            case 10:
                return Combinations.parse(dis);
            case 11:
                return Combination.parse(dis);
            default:
                return new ScreenCaptureResponseAction(new byte[0]);
        }
    }

    public abstract void toDataOutputStream(DataOutputStream var1) throws IOException;
}
