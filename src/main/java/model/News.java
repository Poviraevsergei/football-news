package model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class News {
    private String title;
    private String photo;
    private String text;
}
