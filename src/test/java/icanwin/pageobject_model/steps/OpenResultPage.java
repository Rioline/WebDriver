package icanwin.pageobject_model.steps;

import icanwin.pageobject_model.page.PastebinHomePage;

public record OpenResultPage(PastebinHomePage pastebinHomePage) {

    public void createPastebin(String codeText, String pasteExpiration, String pasteName) {
        pastebinHomePage.openPage();
        pastebinHomePage.popUp();
        pastebinHomePage.fillCodeText(codeText);
        pastebinHomePage.fillPasteExpiration(pasteExpiration);
        pastebinHomePage.fillPasteName(pasteName);
        pastebinHomePage.submitCreatingPaste();
        pastebinHomePage.popUp();
    }

}
