package com.trevisan.hubspot.restmessages.hubspot.crm;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ContactResponseProperties(@JsonProperty("createdate") String createdate,
                                        @JsonProperty("email") String email,
                                        @JsonProperty("firstname") String firstname,
                                        @JsonProperty("hs_all_contact_vids") String hsAllContactVids,
                                        @JsonProperty("hs_associated_target_accounts") String hsAssociatedTargetAccounts,
                                        @JsonProperty("hs_currently_enrolled_in_prospecting_agent") String hsCurrentlyEnrolledInProspectingAgent,
                                        @JsonProperty("hs_email_domain") String hsEmailDomain,
                                        @JsonProperty("hs_full_name_or_email") String hsFullNameOrEmail,
                                        @JsonProperty("hs_is_contact") String hsIsContact,
                                        @JsonProperty("hs_is_unworked") String hsIsUnworked,
                                        @JsonProperty("hs_lifecyclestage_lead_date") String hsLifecyclestageLeadDate,
                                        @JsonProperty("hs_marketable_status") String hsMarketableStatus,
                                        @JsonProperty("hs_marketable_until_renewal") String hsMarketableUntilRenewal,
                                        @JsonProperty("hs_membership_has_accessed_private_content") String hsMembershipHasAccessedPrivateContent,
                                        @JsonProperty("hs_object_id") String hsObjectId,
                                        @JsonProperty("hs_object_source") String hsObjectSource,
                                        @JsonProperty("hs_object_source_id") String hsObjectSourceId,
                                        @JsonProperty("hs_object_source_label") String hsObjectSourceLabel,
                                        @JsonProperty("hs_pipeline") String hsPipeline,
                                        @JsonProperty("hs_prospecting_agent_actively_enrolled_count") String hsProspectingAgentActivelyEnrolledCount,
                                        @JsonProperty("hs_registered_member") String hsRegisteredMember,
                                        @JsonProperty("hs_sequences_actively_enrolled_count") String hsSequencesActivelyEnrolledCount,
                                        @JsonProperty("lastmodifieddate") String lastmodifieddate,
                                        @JsonProperty("lastname") String lastname,
                                        @JsonProperty("lifecyclestage") String lifecyclestage,
                                        @JsonProperty("num_notes") String numNotes) {
}
