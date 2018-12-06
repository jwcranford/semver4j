package com.vdurmont.semver4j;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * Valid semver examples from
 * https://github.com/semver/semver.org/issues/59#issuecomment-390854010
 */
@RunWith(Parameterized.class)
public class SemverValidTest {

  private final String valueToTest;

  public SemverValidTest(String valueToTest) {
    this.valueToTest = valueToTest;
  }

  @Parameterized.Parameters
  public static Collection<String> validParms() {
    return Arrays.asList(
        "0.0.4",
        "1.2.3",
        "10.20.30",
        "1.1.2-prerelease+meta",
        "1.1.2+meta",
        "1.1.2+meta-valid",
        "1.0.0-alpha",
        "1.0.0-beta",
        "1.0.0-alpha.beta",
        "1.0.0-alpha.beta.1",
        "1.0.0-alpha.1",
        "1.0.0-alpha0.valid",
        "1.0.0-alpha.0valid",
        "1.0.0-alpha-a.b-c-somethinglong+build.1-aef.1-its-okay",
        "1.0.0-rc.1+build.1",
        "2.0.0-rc.1+build.123",
        "1.2.3-beta",
        "10.2.3-DEV-SNAPSHOT",
        "1.2.3-SNAPSHOT-123",
        "1.0.0",
        "2.0.0",
        "1.1.7",
        "2.0.0+build.1848",
        "2.0.1-alpha.1227",
        "1.0.0-alpha+beta",
        "1.2.3----RC-SNAPSHOT.12.9.1--.12+788",
        "1.2.3----R-S.12.9.1--.12+meta",
        "1.2.3----RC-SNAPSHOT.12.9.1--.12",
        "1.0.0+0.build.1-rc.10000aaa-kk-0.1"

        // The semver spec doesn't give an upper limit to version numbers. This
        // value fails because the Semver project uses Integers to store major,
        // minor, and patch. But does Semver really need to support a version number
        // over 2 billion?  Probably not.
//        "99999999999999999999999.999999999999999999.99999999999999999"
    );
  }


  @Test
  public void test() {
    new Semver(valueToTest);
  }
}
