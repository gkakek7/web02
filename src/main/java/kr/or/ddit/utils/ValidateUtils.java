package kr.or.ddit.utils;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.hibernate.validator.messageinterpolation.ResourceBundleMessageInterpolator;
import org.hibernate.validator.resourceloading.PlatformResourceBundleLocator;

import kr.or.ddit.validate.InsertGroup;
import kr.or.ddit.vo.MemberVO;

public class ValidateUtils {
	private static Validator validator;
	
	static {
//		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
//		validator = validatorFactory.getValidator();
		validator = Validation.byDefaultProvider()
		        .configure()
		        .messageInterpolator(
		                new ResourceBundleMessageInterpolator(
		                        new PlatformResourceBundleLocator( "kr.or.ddit.message.ErrorMessages" )
		                )
		        )
		        .buildValidatorFactory()
		        .getValidator();
	}
	public static <T> boolean validate(T target, Map<String, String> errors ,Class<?>...groups) {
		boolean valid=true;
		Set<ConstraintViolation<T>> constraintViolations = validator.validate(target,groups);
		Map<String, String> others = constraintViolations.stream()
				.collect(Collectors.toMap(v-> v.getPropertyPath().toString(), v-> v.getMessage()));
		errors.putAll(others);
		valid = others.isEmpty();
		return valid;
	}
}
