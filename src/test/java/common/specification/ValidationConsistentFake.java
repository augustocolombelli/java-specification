package common.specification;

import common.specification.ValidationBase;

public class ValidationConsistentFake extends ValidationBase<DomainEntityOneFake> {

	@Override
	public String getMessageTemplate() {
		return FakeValidationMessageHelper.IS_NOT_CONSISTENT;
	}

	@Override
	public boolean isSatisfied(DomainEntityOneFake fakeEntity) {
		return fakeEntity.isConsistent();
	}

}
