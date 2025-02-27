package io.mosip.admin.bulkdataupload.entity;

import java.io.Serializable;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import io.mosip.admin.bulkdataupload.entity.id.RegistrationCenterDeviceID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 
 * Entity class to map Registration center id and Device id.
 * 
 * @author Bal Vikash Sharma
 * @since 1.0.0
 *
 */

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reg_center_device", schema = "master")
public class RegistrationCenterDevice extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -8541947587557590379L;

	@EmbeddedId
	@AttributeOverrides({ @AttributeOverride(name = "regCenterId", column = @Column(name = "regcntr_id")),
			@AttributeOverride(name = "deviceId", column = @Column(name = "device_id")) })
	private RegistrationCenterDeviceID registrationCenterDevicePk;

	@Column(name = "lang_code", nullable = false, length = 3)
	private String langCode;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "device_id", referencedColumnName = "id", insertable = false, updatable = false),
			@JoinColumn(name = "lang_code", referencedColumnName = "lang_code", insertable = false, updatable = false) })
	private Device device;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "regcntr_id", referencedColumnName = "id", insertable = false, updatable = false),
			@JoinColumn(name = "lang_code", referencedColumnName = "lang_code", insertable = false, updatable = false) })
	private RegistrationCenter registrationCenter;

}
