package com.outlook.twentysevenclup.data;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class TSData {

    private File file;

    private YamlConfiguration yamlConfiguration;

    public TSData(String fileName) {
        this.file = new File(fileName);
        this.yamlConfiguration = YamlConfiguration.loadConfiguration(this.file);
    }

    public File getFile() { return this.file; }

    public YamlConfiguration getYamlConfiguration() { return this.yamlConfiguration; }

    public void set(String path, Object value) {
        this.yamlConfiguration.set(path, value);
    }

    public Object get(String path) { return this.yamlConfiguration.get(path); }

    public void load() {
        try {
            this.yamlConfiguration.load(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void save() {
        try {
            if (!this.file.exists()) {
                if (!this.file.getParentFile().exists()) {
                    this.file.getParentFile().mkdir();
                }
                this.file.createNewFile();
            }
            this.yamlConfiguration.save(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean exists() { return this.file.exists(); }

    public static boolean exists(String fileName) { return new File(fileName).exists(); }

}
