package com.vdurmont.semver4j;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.fail;

/**
 * Invalid semver examples from
 * https://github.com/semver/semver.org/issues/59#issuecomment-390854010
 */
@RunWith(Parameterized.class)
public class SemverInvalidTest {

  private final String valueToTest;

  public SemverInvalidTest(String valueToTest) {
    this.valueToTest = valueToTest;
  }

  @Parameterized.Parameters
  public static Collection<String> invalidParms() {
    return Arrays.asList(
        "1",
        "1.2",
        "1.2.3-0123",
        "1.2.3-0123.0123",
        "1.1.2+.123",
        "+invalid",
        "-invalid",
        "-invalid+invalid",
        "-invalid.01",
        "alpha",
        "alpha.beta",
        "alpha.beta.1",
        "alpha.1",
        "alpha+beta",
        "alpha_beta",
        "alpha.",
        "alpha..",
        "beta\\",
        "1.0.0-alpha_beta",
        "-alpha.",
        "1.0.0-alpha..",
        "1.0.0-alpha..1",
        "1.0.0-alpha...1",
        "1.0.0-alpha....1",
        "1.0.0-alpha.....1",
        "1.0.0-alpha......1",
        "1.0.0-alpha.......1",
        "01.1.1",
        "1.01.1",
        "1.1.01",
        "1.2",
        "1.2.3.DEV",
        "1.2-SNAPSHOT",
        "1.2.31.2.3----RC-SNAPSHOT.12.09.1--..12+788",
        "1.2-RC-SNAPSHOT",
        "-1.0.3-gamma+b7718",
        "+justmeta",
        "9.8.7+meta+meta",
        "9.8.7-whatever+meta+meta",
        "99999999999999999999999.999999999999999999.99999999999999999----RC-SNAPSHOT.12.09.1--------------------------------..12"

        // These test values fail in Semver.

        // Spec does not support leading zeroes in numeric identifiers
        // (rules #2, #9)

    );
  }


  @Test
  public void test() {
    try {
      new Semver(valueToTest);
      fail("Expected SemverException on " + valueToTest);
    } catch (SemverException e) {
      // expected
    }
  }
}
