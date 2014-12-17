package com.rvcode.ydiagram;

import com.intellij.diagram.DiagramNodeBase;
import com.intellij.diagram.DiagramProvider;
import com.intellij.psi.xml.XmlDocument;
import com.intellij.psi.xml.XmlTag;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;


public class ProcessNode extends DiagramNodeBase<XmlDocument> {

    private final XmlTag tag;
    private static final String ID_ATTRIBUTE = "id";

    public ProcessNode(@NotNull DiagramProvider<XmlDocument> provider, final XmlTag tag) {
        super(provider);
        this.tag = tag;
    }

    @Nullable
    @Override
    public String getTooltip() {
        return tag.getAttributeValue(ID_ATTRIBUTE);
    }

    @Override
    public Icon getIcon() {
        return null;
    }


    @NotNull
    @Override
    public XmlDocument getIdentifyingElement() {
        return (XmlDocument) tag.getContainingFile();
    }

    public XmlTag getTag() {
        return tag;
    }
}
