package org.eclipse.dirigible.core.extensions.definition;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import org.eclipse.dirigible.commons.api.helpers.GsonHelper;

@Table(name="DIRIGIBLE_EXTENSION_POINTS")
public class ExtensionPointDefinition {
	
	@Id
	@Column(name="EXTENSIONPOINT_LOCATION", columnDefinition="VARCHAR", nullable=false, length=255)
	private String location;
	
	@Column(name="EXTENSIONPOINT_NAME", columnDefinition="VARCHAR", nullable=false, length=255, unique=true)
	private String name;
	
	@Column(name="EXTENSIONPOINT_DESCRIPTION", columnDefinition="VARCHAR", nullable=true, length=1024)
	private String description;
	
	@Column(name="EXTENSIONPOINT_CREATED_BY", columnDefinition="VARCHAR", nullable=false, length=32)
	private String createdBy;
	
	@Column(name="EXTENSIONPOINT_CREATED_AT", columnDefinition="TIMESTAMP", nullable=false)
	private Timestamp createdAt;
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public static ExtensionPointDefinition fromJson(String json) {
		return GsonHelper.GSON.fromJson(json, ExtensionPointDefinition.class);
	}
	
	public String toJson() {
		return GsonHelper.GSON.toJson(this, ExtensionPointDefinition.class);
	}
	
	@Override
	public String toString() {
		return toJson();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExtensionPointDefinition other = (ExtensionPointDefinition) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}