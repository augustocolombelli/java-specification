package common.specification;

import common.specification.ValidationBase;

public class ValidationStartedFake extends ValidationBase<DomainEntityTwoFake> {

	@Override
	public String getMessageTemplate() {
		return FakeValidationMessageHelper.IS_NOT_STARTED;
	}

	@Override
	public boolean isSatisfied(DomainEntityTwoFake fakeEntity) {
		return fakeEntity.isStarted();
	}
	
	@Override
	protected Object[] getMessageParameters(DomainEntityTwoFake target) {
		Object[] objects = {target};
		return objects;
	}

}
