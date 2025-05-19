package com.min.edu.domain;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatedBookRequest {

	@NotEmpty(message = "제목은 필수 입력 값입니다")
	private String title;
	@NotEmpty(message = "URL은 필수 입력 값입니다")
	private String url;
}
