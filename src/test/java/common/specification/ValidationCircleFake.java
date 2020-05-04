package common.specification;

import common.specification.ValidationBase;

public class ValidationCircleFake extends ValidationBase<DomainEntityTwoFake> {

	@Override
	public String getMessageTemplate() {
		return FakeValidationMessageHelper.IS_NOT_CIRCLE;
	}

	@Override
	public boolean isSatisfied(DomainEntityTwoFake fakeEntity) {
		return fakeEntity.isCircle();
	}

}
