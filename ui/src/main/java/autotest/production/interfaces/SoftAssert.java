package autotest.production.interfaces;

import autotest.production.asserts.CustomSoftAssertions;

@FunctionalInterface
public interface SoftAssert {

    void doSoftAssert(CustomSoftAssertions customSoftAssertions);

}