package com.rvcode.ydiagram;

import com.intellij.diagram.DiagramEdgeBase;
import com.intellij.diagram.DiagramNode;
import com.intellij.diagram.DiagramProvider;
import com.intellij.diagram.DiagramRelationshipInfo;
import com.intellij.openapi.util.Key;
import com.intellij.psi.xml.XmlDocument;
import com.intellij.psi.xml.XmlTag;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class ProcessTransition extends DiagramEdgeBase<XmlDocument> {

    private final XmlTag tag;

    public ProcessTransition(final DiagramNode<XmlDocument> source, final DiagramNode<XmlDocument> target,
                             final DiagramRelationshipInfo relationship, final XmlTag tag) {
        super(source, target, relationship);
        this.tag = tag;
    }
}
