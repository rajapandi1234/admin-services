package io.mosip.kernel.masterdata.controller;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.mosip.kernel.core.http.RequestWrapper;
import io.mosip.kernel.core.http.ResponseFilter;
import io.mosip.kernel.core.http.ResponseWrapper;
import io.mosip.kernel.masterdata.dto.ApplicationDto;
import io.mosip.kernel.masterdata.dto.getresponse.ApplicationResponseDto;
import io.mosip.kernel.masterdata.entity.id.CodeAndLanguageCodeID;
import io.mosip.kernel.masterdata.service.ApplicationService;
import io.swagger.annotations.Api;

/**
 * Controller APIs to get Application types details
 * 
 * @author Neha
 * @since 1.0.0
 *
 */

@Api(tags = { "Application" })
@RestController
@RequestMapping("/applicationtypes")
public class ApplicationController {

	@Autowired
	private ApplicationService applicationService;

	/**
	 * API to fetch all Application details
	 * 
	 * @return All Application details
	 */
	//@PreAuthorize("hasAnyRole('GLOBAL_ADMIN','ZONAL_ADMIN')")
	@ResponseFilter
	//@PreAuthorize("hasAnyRole(@authorizedRoles.getGetapplicationtypes())")
	@Deprecated(since = "1.2.0")
	@GetMapping
	public ResponseWrapper<ApplicationResponseDto> getAllApplication() {
		ResponseWrapper<ApplicationResponseDto> responseWrapper = new ResponseWrapper<>();
		responseWrapper.setResponse(applicationService.getAllApplication());
		return responseWrapper;
	}

	/**
	 * API to fetch all Application details by language code
	 * 
	 * @param langCode the language code
	 * 
	 * @return All Application details
	 */
	//@PreAuthorize("hasAnyRole('RESIDENT','GLOBAL_ADMIN','ZONAL_ADMIN','INDIVIDUAL','REGISTRATION_PROCESSOR','PRE_REGISTRATION','REGISTRATION_SUPERVISOR','REGISTRATION_OFFICER','PARTNER','AUTH_PARTNER','PARTNER_ADMIN','DEVICE_PROVIDER','DEVICE_MANAGER')")
	@ResponseFilter
	//@PreAuthorize("hasAnyRole(@authorizedRoles.getGetapplicationtypeslangcode())")
	@Deprecated(since = "1.2.0")
	@GetMapping("/{langcode}")
	public ResponseWrapper<ApplicationResponseDto> getAllApplicationByLanguageCode(
			@PathVariable("langcode") String langCode) {
		ResponseWrapper<ApplicationResponseDto> responseWrapper = new ResponseWrapper<>();
		responseWrapper.setResponse(applicationService.getAllApplicationByLanguageCode(langCode));
		return responseWrapper;
	}

	/**
	 * API to fetch all Application details by language code
	 * 
	 * @param code     the code
	 * 
	 * @param langCode the language code
	 * 
	 * @return Application detail
	 */
	//@PreAuthorize("hasAnyRole('RESIDENT','GLOBAL_ADMIN','ZONAL_ADMIN','INDIVIDUAL','REGISTRATION_PROCESSOR','PRE_REGISTRATION','REGISTRATION_SUPERVISOR','REGISTRATION_OFFICER','PARTNER','AUTH_PARTNER','PARTNER_ADMIN','DEVICE_PROVIDER','DEVICE_MANAGER')")
	@ResponseFilter
	//@PreAuthorize("hasAnyRole(@authorizedRoles.getGetapplicationtypescodelangcode())")
	@Deprecated(since = "1.2.0")
	@GetMapping("/{code}/{langcode}")
	public ResponseWrapper<ApplicationResponseDto> getApplicationByCodeAndLanguageCode(
			@PathVariable("code") String code, @PathVariable("langcode") String langCode) {
		ResponseWrapper<ApplicationResponseDto> responseWrapper = new ResponseWrapper<>();
		responseWrapper.setResponse(applicationService.getApplicationByCodeAndLanguageCode(code, langCode));
		return responseWrapper;
	}

	/**
	 * API to create Application detail
	 * 
	 * @param application the application detail
	 * 
	 * @return {@linkplain CodeAndLanguageCodeID}
	 */
	@ResponseFilter
	//@PreAuthorize("hasAnyRole('GLOBAL_ADMIN','ZONAL_ADMIN')")
	@PreAuthorize("hasAnyRole(@authorizedRoles.getPostapplicationtypes())")
	@Deprecated(since = "1.2.0")
	@PostMapping
	public ResponseWrapper<CodeAndLanguageCodeID> createApplication(
			@Valid @RequestBody RequestWrapper<ApplicationDto> application) {
		ResponseWrapper<CodeAndLanguageCodeID> responseWrapper = new ResponseWrapper<>();
		responseWrapper.setResponse(applicationService.createApplication(application.getRequest()));
		return responseWrapper;

	}
}
