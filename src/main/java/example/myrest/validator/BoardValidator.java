package example.myrest.validator;

import example.myrest.model.Board;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class BoardValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Board.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Board board = (Board) target;
        if (!StringUtils.hasText(board.getContent())) {
            errors.rejectValue("content", "key", "내용을 입력하세요");
        }
    }
}
