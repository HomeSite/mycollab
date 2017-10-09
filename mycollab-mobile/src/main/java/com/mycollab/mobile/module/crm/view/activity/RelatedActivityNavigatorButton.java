package com.mycollab.mobile.module.crm.view.activity;

import com.mycollab.common.i18n.GenericI18Enum;
import com.mycollab.db.arguments.NumberSearchField;
import com.mycollab.db.arguments.StringSearchField;
import com.mycollab.module.crm.CrmTypeConstants;
import com.mycollab.module.crm.domain.criteria.ActivitySearchCriteria;
import com.mycollab.module.crm.i18n.CrmCommonI18nEnum;
import com.mycollab.module.crm.service.EventService;
import com.mycollab.spring.AppContextUtil;
import com.mycollab.vaadin.AppUI;
import com.mycollab.vaadin.UserUIContext;
import com.vaadin.addon.touchkit.ui.NavigationButton;

/**
 * @author MyCollab Ltd
 * @since 5.4.9
 */
public class RelatedActivityNavigatorButton extends NavigationButton {
    private ActivitySearchCriteria criteria;

    public RelatedActivityNavigatorButton() {
        super(UserUIContext.getMessage(GenericI18Enum.OPT_ITEM_VALUE,
                UserUIContext.getMessage(CrmCommonI18nEnum.TAB_ACTIVITY), 0));
        this.addClickListener(navigationButtonClickEvent -> {
            if (criteria != null) {
                getNavigationManager().navigateTo(new ActivityListDisplayView(criteria));
            }
        });
    }

    void displayTotalActivities(ActivitySearchCriteria criteria) {
        this.criteria = criteria;
        EventService eventService = AppContextUtil.getSpringBean(EventService.class);
        this.setCaption(UserUIContext.getMessage(GenericI18Enum.OPT_ITEM_VALUE,
                UserUIContext.getMessage(CrmCommonI18nEnum.TAB_ACTIVITY), eventService.getTotalCount(criteria)));
    }

    public void displayRelatedByAccount(Integer accountId) {
        ActivitySearchCriteria searchCriteria = new ActivitySearchCriteria();
        searchCriteria.setSaccountid(NumberSearchField.equal(AppUI.getAccountId()));
        searchCriteria.setType(StringSearchField.and(CrmTypeConstants.ACCOUNT));
        searchCriteria.setTypeid(NumberSearchField.equal(accountId));
        displayTotalActivities(searchCriteria);
    }

    public void displayRelatedByContact(Integer contactId) {
        ActivitySearchCriteria searchCriteria = new ActivitySearchCriteria();
        searchCriteria.setType(StringSearchField.and(CrmTypeConstants.CONTACT));
        searchCriteria.setTypeid(NumberSearchField.equal(contactId));
        displayTotalActivities(searchCriteria);
    }

    public void displayRelatedByCampaign(Integer campaignId) {
        ActivitySearchCriteria searchCriteria = new ActivitySearchCriteria();
        searchCriteria.setType(StringSearchField.and(CrmTypeConstants.CAMPAIGN));
        searchCriteria.setTypeid(NumberSearchField.equal(campaignId));
        displayTotalActivities(searchCriteria);
    }

    public void displayRelatedByLead(Integer leadId) {
        ActivitySearchCriteria searchCriteria = new ActivitySearchCriteria();
        searchCriteria.setType(StringSearchField.and(CrmTypeConstants.LEAD));
        searchCriteria.setTypeid(NumberSearchField.equal(leadId));
        displayTotalActivities(searchCriteria);
    }

    public void displayRelatedByOpportunity(Integer opportunityId) {
        ActivitySearchCriteria searchCriteria = new ActivitySearchCriteria();
        searchCriteria.setType(StringSearchField.and(CrmTypeConstants.OPPORTUNITY));
        searchCriteria.setTypeid(NumberSearchField.equal(opportunityId));
        displayTotalActivities(searchCriteria);
    }

    public void displayRelatedByCase(Integer caseId) {
        ActivitySearchCriteria searchCriteria = new ActivitySearchCriteria();
        searchCriteria.setType(StringSearchField.and(CrmTypeConstants.CASE));
        searchCriteria.setTypeid(NumberSearchField.equal(caseId));
        displayTotalActivities(searchCriteria);
    }
}