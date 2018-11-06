package com.gmail.bishoybasily.messenger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Matcher extends HashSet<Subscriber> {

    public Set<Subscriber> matches(String phrase) {

        Set<Subscriber> results = new HashSet<>();

        String[] phraseSegments = segmentsOf(phrase);

        Iterator<Subscriber> iterator = iterator();
        while (iterator.hasNext()) {
            Subscriber subscriber = iterator.next();

            String key = subscriber.getKey();

            String[] subscriberSegments = segmentsOf(key);

            if (areEquals(phraseSegments, subscriberSegments))
                results.add(subscriber);

        }

        return results;
    }

    private String[] segmentsOf(String phrase) {
        return phrase.split("\\.");
    }

    private boolean areEquals(String[] left, String[] right) {

        int maximumLength = maximumLength(left, right);
        left = cleanUp(left, maximumLength);
        right = cleanUp(right, maximumLength);

        for (int i = 0; i < left.length; i++)
            if (!areEquals(left[i], right[i]))
                return false;

        return true;
    }

    private boolean areEquals(String left, String right) {
        return left.equals("*") || right.equals("*") || left.equals(right);
    }

    private String[] cleanUp(String[] parts, int length) {
        if (length < parts.length)
            return parts;

        ArrayList<String> segments = new ArrayList<>(Arrays.asList(parts));

        int hashIndex = segments.indexOf("#");

        if (hashIndex != -1) {
            segments.set(hashIndex, "*");

            int missingLength = length - parts.length;
            for (int i = 0; i < missingLength; i++)
                segments.add(i + hashIndex, "*");

        }

        return segments.toArray(new String[segments.size()]);
    }

    private int maximumLength(String[]... arrays) {
        int result = 0;
        for (String[] arr : arrays) {
            if (arr.length > result)
                result = arr.length;
        }
        return result;
    }

}
