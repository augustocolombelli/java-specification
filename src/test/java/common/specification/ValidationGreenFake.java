package common.specification;

import common.specification.ValidationBase;

public class ValidationGreenFake extends ValidationBase<DomainEntityTwoFake> {

	@Override
	public String getMessageTemplate() {
		return FakeValidationMessageHelper.IS_NOT_GREEN;
	}

	@Override
	public boolean isSatisfied(DomainEntityTwoFake fakeEntity) {
		return fakeEntity.isGreen();
	}

}
