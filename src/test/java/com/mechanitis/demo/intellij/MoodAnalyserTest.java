package com.mechanitis.demo.intellij;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://www.jetbrains.com/help/idea/tdd-with-intellij-idea.html
 */
public class MoodAnalyserTest {

	@Test
	public void testMoodAnalysis() {
		MoodAnalyser moodAnalyser = new MoodAnalyser();
		String mood = moodAnalyser.analyseMood("this is a sad method");
		Assert.assertThat(mood, CoreMatchers.is("SAD"));
	}

	@Test
	public void testHappyMoods() {
		MoodAnalyser moodAnalyser = new MoodAnalyser();
		String mood = moodAnalyser.analyseMood("this is a happy method");
		Assert.assertThat(mood, CoreMatchers.is("HAPPY"));
	}
}


