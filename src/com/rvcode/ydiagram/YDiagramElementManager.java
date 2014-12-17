package com.rvcode.ydiagram;

import com.intellij.diagram.AbstractDiagramElementManager;
import com.intellij.diagram.presentation.DiagramState;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.psi.xml.XmlDocument;
import com.intellij.ui.SimpleColoredText;
import org.jetbrains.annotations.Nullable;

public class YDiagramElementManager extends AbstractDiagramElementManager<XmlDocument> {
    @Nullable
    @Override
    public XmlDocument findInDataContext(DataContext dataContext) {
        return null;
    }

    @Override
    public boolean isAcceptableAsNode(Object o) {
        return false;
    }

    @Nullable
    @Override
    public String getElementTitle(XmlDocument xmlDocument) {
        return null;
    }

    @Nullable
    @Override
    public SimpleColoredText getItemName(Object o, DiagramState diagramState) {
        return null;
    }

    @Override
    public String getNodeTooltip(XmlDocument xmlDocument) {
        return null;
    }
}
