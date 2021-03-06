package sentimentAnalyzer;

import java.util.Arrays;

public class SentimentAnalyzer
{
	public static int[] detectProsAndCons(String review, String[][] featureSet, String[] posOpinionWords, String[] negOpinionWords)
	{
		int[] featureOpinions = new int[featureSet.length];
 
		int count = 0;	
		for (String [] features : featureSet)
		{
			for (String feature : features)
			{	
				int getValue = getOpinionOnFeature(review, feature, posOpinionWords, negOpinionWords);
				featureOpinions[count] = getValue;
				if (getValue > 0 || getValue < 0)
				{
					break;
				}
			}
			count += 1;
		}
		return featureOpinions;
	}

	private static int getOpinionOnFeature(String review, String feature, String[] posOpinionWords, String[] negOpinionWords)
	{
		int opinion = 0;
		String reviewLowerCase = review.toLowerCase();

		if (reviewLowerCase.contains(feature + " was"))
		{
			int getValue = checkForWasPhrasePattern(review, feature, posOpinionWords, negOpinionWords);
			opinion = getValue;
		}
		else if(reviewLowerCase.contains(" " + feature))
		{
			int getValue = checkForOpinionFirstPattern(review, feature, posOpinionWords, negOpinionWords);
			opinion = getValue;
		}
		return opinion;	
	}		

	private static int checkForWasPhrasePattern(String review, String feature, String[] posOpinionWords, String[] negOpinionWords)
	{
		int opinion = 0;
		String reviewLowerCase = review.toLowerCase();
		String pattern = feature + " was ";

		for (String posOpinionWord : posOpinionWords)
		{
			String patternWasPosOpinionWord = pattern + posOpinionWord;
			if (reviewLowerCase.contains(patternWasPosOpinionWord))
			{
//				System.out.println(patternWasPosOpinionWord);
				opinion += 1;
			}
		}
		for (String negOpinionWord : negOpinionWords)
		{
			String patternWasNegOpinionWord = pattern + negOpinionWord;
			if (reviewLowerCase.contains(patternWasNegOpinionWord))
			{
//				System.out.println(patternWasNegOpinionWord);
				opinion -= 1;
			}
		}
		return opinion; 	
	}
	
	private static int checkForOpinionFirstPattern(String review, String feature, String[] posOpinionWords, String[] negOpinionWords)
	{
		int opinion = 0;
		String reviewLowerCase = review.toLowerCase();
		String pattern = " " + feature;

		for (String posOpinionWord : posOpinionWords)
		{
			String patternOpinionFirstPosOpinionWord = posOpinionWord + pattern;
			if (reviewLowerCase.contains(patternOpinionFirstPosOpinionWord))
			{
//				System.out.println(patternOpinionFirstPosOpinionWord);
				opinion += 1;
			}
		}
		for (String negOpinionWord : negOpinionWords)
		{
			String patternOpinionFirstNegOpinionWord = negOpinionWord + pattern;
			if (reviewLowerCase.contains(patternOpinionFirstNegOpinionWord))
			{
//				System.out.println(patternOpinionFirstNegOpinionWord);
				opinion -= 1;
			}
		}
		return opinion;
	}

	public static void main(String[] args)
	{
		String review = "Haven't been here in years! Fantastic service and the food was delicious! "
					  + "Definetly will be a frequent flyer! Francisco was very attentive";

//		String review = "Sorry OG, but you just lost some loyal customers. "
//					  + "Horrible service, no smile or greeting just attitude. "
//					  + "The breadsticks were stale and burnt, appetizer was cold and the food came out before the salad.";
		
		String[][] featureSet = { 
		        { "ambiance", "ambience", "atmosphere", "decor" },
				{ "dessert", "ice cream", "desert" }, 
				{ "food" }, 
				{ "soup" },
				{ "service", "management", "waiter", "waitress", "bartender", "staff", "server" } };
		
		String[] posOpinionWords = { "good", "fantastic", "friendly", "great", "excellent", 
									 "amazing", "awesome", "delicious" };
		
		String[] negOpinionWords = { "slow", "bad", "horrible", "awful", "unprofessional", "poor" };

		int[] featureOpinions = detectProsAndCons(review, featureSet, posOpinionWords, negOpinionWords);
		System.out.println("Opinions on Features: " + Arrays.toString(featureOpinions));
	}
}