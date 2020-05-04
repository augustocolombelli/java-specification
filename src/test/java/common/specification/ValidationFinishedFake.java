package common.specification;

import common.specification.ValidationBase;

public class ValidationFinishedFake extends ValidationBase<DomainEntityOneFake> {

	@Override
	public String getMessageTemplate() {
		return FakeValidationMessageHelper.IS_NOT_FINISHED;
	}

	@Override
	public boolean isSatisfied(DomainEntityOneFake fakeEntity) {
		return fakeEntity.isFinished();
	}
}
