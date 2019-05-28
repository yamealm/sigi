package com.args.sigi.object;

public class Provider  {

   
    private Long id;
    private String name;
    private String address;
    private boolean enabled;

    public Provider() {
    }

    public Provider(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
    public String toString() {
        return super.toString();
    }

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }


    @Override
    public boolean equals(Object object) {
        if (object instanceof Provider) {
            return this.getId().equals(((Provider) object).getId());
        } else {
            return false;
        }
    }
}
