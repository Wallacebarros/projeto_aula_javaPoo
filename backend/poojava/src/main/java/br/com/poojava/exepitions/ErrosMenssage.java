package br.com.poojava.exepitions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrosMenssage {
    private int code;
    private String menssage;
}
