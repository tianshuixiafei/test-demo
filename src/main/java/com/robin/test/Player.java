package com.robin.test;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@Data
public class Player {

    private String name;
    private String team;
    private Integer age;
    private Integer score;

}
