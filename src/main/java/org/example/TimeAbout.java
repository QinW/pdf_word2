package org.example;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TimeAbout {

    public static void main(String[] args) {
        Instant now = Instant.now();
        ZonedDateTime z0 = now.atZone(ZoneId.of("Asia/Shanghai"));
        ZonedDateTime z1 = now.atZone(ZoneId.of("CET"));
        ZonedDateTime z2 = now.atZone(ZoneId.of("America/Los_Angeles"));
        System.out.println(z0);
        System.out.println(z1);
        System.out.println(z2);
    }
}
