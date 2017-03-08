package com.burnweb.rnwebview;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

public class ReceiveHttpAuthRequestEvent extends Event<ReceiveHttpAuthRequestEvent> {

    public static final String EVENT_NAME = "receiveHttpAuthRequest";

    private final String mHost;
    private final String mRealm;

    public ReceiveHttpAuthRequestEvent(int viewId, String host, String realm) {
        super(viewId);

        mHost = host;
        mRealm = realm;
    }

    @Override
    public String getEventName() {
        return EVENT_NAME;
    }

    @Override
    public void dispatch(RCTEventEmitter rctEventEmitter) {
        rctEventEmitter.receiveEvent(getViewTag(), getEventName(), serializeEventData());
    }

    private WritableMap serializeEventData() {
        WritableMap eventData = Arguments.createMap();
        eventData.putString("host", mHost);
        eventData.putString("realm", mRealm);

        return eventData;
    }
}
