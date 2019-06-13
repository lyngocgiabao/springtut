package rmit.team5.springtut.Validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;


@Documented
@Constraint(validatedBy =PhoneExistedValidator.class)
//@Target({ElementType.TYPE,ElementType.ANNOTATION_TYPE})
@Target( { ElementType.METHOD, ElementType.FIELD })

@Retention(RetentionPolicy.RUNTIME)
public @interface PhoneExistedConstraint {
    String message() default "Invalid phone number";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
