package fr.mrcubee.annotation.spigot.config;

import org.bukkit.ChatColor;

import java.util.List;

public class ConfigColoredValue {

    public static Object setColor(Object object, char colorChar) {
        String[] tabValues;
        List<Object> values;

        if (object == null)
            return null;
        if (object instanceof String)
            return ChatColor.translateAlternateColorCodes(colorChar, (String) object);
        if (object instanceof String[]) {
            tabValues = (String[]) object;
            for (int i = 0; i < tabValues.length; i++)
                tabValues[i] = ChatColor.translateAlternateColorCodes(colorChar, tabValues[i]);
            return tabValues;
        }
        if (object instanceof List<?>) {
            values = (List<Object>) object;
            for (int i = 0; i < values.size(); i++)
                values.set(i, setColor(values.get(i), colorChar));
            return values;
        }
        return object;
    }

}
