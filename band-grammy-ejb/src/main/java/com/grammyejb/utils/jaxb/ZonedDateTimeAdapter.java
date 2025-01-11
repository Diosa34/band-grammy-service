package com.grammyejb.utils.jaxb;


import jakarta.xml.bind.annotation.adapters.XmlAdapter;

import java.time.ZonedDateTime;

public class ZonedDateTimeAdapter extends XmlAdapter<String, ZonedDateTime> {
    public ZonedDateTime unmarshal(String v) {
        return ZonedDateTime.parse(v);
    }

    public String marshal(ZonedDateTime v) {
        return v.toString();
    }
}
