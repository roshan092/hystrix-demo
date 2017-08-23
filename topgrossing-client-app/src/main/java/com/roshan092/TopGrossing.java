package com.roshan092;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class TopGrossing {
    private String movie;
    private String song;
}
