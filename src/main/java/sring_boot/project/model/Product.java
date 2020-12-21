package sring_boot.project.model;

import lombok.*;

@Data // @Getter @Setter и другие аннатации
@NoArgsConstructor // конструктор без аргументов
@AllArgsConstructor // конструктор со всеми аргументами
public class Product {
    private int id;
    private String title;
    private int cost;
}
