package common.specification;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import common.specification.Specifications;
import common.specification.impl.SpecificBusinessException;
import common.specification.impl.SpecificError;
import common.specification.impl.SpecificationsDefault;


@RunWith(MockitoJUnitRunner.class)
public class SpecificationsTest {

	private Specifications specifications;

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Before
	public void setUp() {
		specifications = new SpecificationsDefault();
	}
	
	@Test
	public void shouldValidateOneRuleForOneDomainEntity() {
		DomainEntityOneFake toValidateFake = new DomainEntityOneFake(false, false);

		expectedException.expect(SpecificBusinessException.class);

		specifications.of(new ValidationConsistentFake()).validate(toValidateFake);
	}
	
	@Test
	@SuppressWarnings("unchecked")
	public void shouldValidateTwoRulesForOneDomainEntity() {
		DomainEntityOneFake toValidateFake = new DomainEntityOneFake(false, false);

		expectedException.expect(SpecificBusinessException.class);

		specifications.of(
				new ValidationConsistentFake(),
				new ValidationFinishedFake()
				).validate(toValidateFake);
	}
	
	@Test
	public void shouldValidateOneRuleForTwoDomainEntity() {
		DomainEntityOneFake oneToValidateFake = new DomainEntityOneFake(false, false);
		DomainEntityTwoFake twoToValidateFake = new DomainEntityTwoFake(false, false, false);

		expectedException.expect(SpecificBusinessException.class);

		specifications.of(new ValidationConsistentFake()).validate(oneToValidateFake);
		specifications.of(new ValidationStartedFake()).validate(twoToValidateFake);
	}
	
	@Test()
	@SuppressWarnings("unchecked")
	public void shouldValidateTwoRulesForTwoDomainEntity() {
		DomainEntityOneFake oneToValidateFake = new DomainEntityOneFake(false, false);
		DomainEntityTwoFake twoToValidateFake = new DomainEntityTwoFake(false, false, false);
		try {
			specifications.of(new ValidationConsistentFake(), new ValidationFinishedFake()).validate(oneToValidateFake);
			specifications.of(new ValidationStartedFake(), new ValidationGreenFake()).validate(twoToValidateFake);
		} catch (SpecificBusinessException exception) {
			assertThat(exception.getErrors(), hasItem(getMatcher(FakeValidationMessageHelper.IS_NOT_CONSISTENT)));
			assertThat(exception.getErrors(), hasItem(getMatcher(FakeValidationMessageHelper.IS_NOT_FINISHED)));
			assertThat(exception.getErrors(), hasSize(2));
		}
	}
	
	@Test()
	@SuppressWarnings("unchecked")
	public void shouldNotValidateWhenAllValidationsIsTrue() {
		DomainEntityTwoFake twoToValidateFake = new DomainEntityTwoFake(true, true, true);
		specifications.of(
				new ValidationStartedFake(), 
				new ValidationGreenFake(), 
				new ValidationCircleFake())
			.validate(twoToValidateFake);
	}
	
	@Test()
	@SuppressWarnings("unchecked")
	public void shouldValidateTwoRulesInThreeValidations() {
		DomainEntityTwoFake twoToValidateFake = new DomainEntityTwoFake(false, false, true);
		try {
			specifications.of(
					new ValidationStartedFake(), 
					new ValidationGreenFake(), 
					new ValidationCircleFake())
			.validate(twoToValidateFake);
		} catch (SpecificBusinessException exception) {
			assertThat(exception.getErrors(), hasItem(getMatcher(FakeValidationMessageHelper.IS_NOT_GREEN)));
			assertThat(exception.getErrors(), hasItem(getMatcher(FakeValidationMessageHelper.IS_NOT_STARTED, twoToValidateFake)));
			assertThat(exception.getErrors(), hasSize(2));
		}
	}
	
	private Matcher<SpecificError> getMatcher(String messageError, Object... params ) {
		return allOf(
			hasProperty("message", equalTo(messageError)),
			hasProperty("messageParameters", equalTo(params))
		);
	}
	
	@SuppressWarnings("unchecked")
	private Matcher<SpecificError> getMatcher(String messageError) {
		return allOf(
			hasProperty("message", equalTo(messageError)));
	}

}
