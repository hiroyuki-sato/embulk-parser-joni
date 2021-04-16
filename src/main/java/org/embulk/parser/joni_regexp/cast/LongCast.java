package org.embulk.parser.joni_regexp.cast;

import org.embulk.spi.DataException;

import java.time.Instant;

public class LongCast
{
    private LongCast() {}

    private static String buildErrorMessage(String as, long value)
    {
        return String.format("cannot cast long to %s: \"%s\"", as, value);
    }

    public static boolean asBoolean(long value) throws DataException
    {
        if (value == 1) {
            return true;
        }
        else if (value == 0) {
            return false;
        }
        else {
            throw new DataException(buildErrorMessage("boolean", value));
        }
    }

    public static long asLong(long value) throws DataException
    {
        return value;
    }

    public static double asDouble(long value) throws DataException
    {
        return (double) value;
    }

    public static String asString(long value) throws DataException
    {
        return String.valueOf(value);
    }

    public static Instant asTimestamp(long value) throws DataException
    {
        return Instant.ofEpochSecond(value);
    }
}
