package com.args.sigi.object;


public class Language {

    public static final Long ENGLISH = 1L;
    public static final Long SPANISH = 2L;
    public static final Long PORTUGUESE = 3L;
    private Long id;
    private String description;
    private boolean enabled;
    private String iso;

    public Language() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getIso() {
        return this.iso;
    }

    public void setIso(String iso) {
        this.iso = iso;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
