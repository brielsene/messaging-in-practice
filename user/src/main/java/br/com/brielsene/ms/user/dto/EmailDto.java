package br.com.brielsene.ms.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmailDto {
    private UUID userId;
    private String emailTo;
    private String subject;
    private String text;
}
