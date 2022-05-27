package org.acme.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Response {

    public String success;

    public String msg;

    public Object data;

}
