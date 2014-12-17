package com.rvcode.ydiagram;

import com.intellij.diagram.*;
import com.intellij.diagram.presentation.DiagramLineType;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.ModificationTracker;
import com.intellij.psi.xml.XmlDocument;
import com.intellij.psi.xml.XmlTag;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class YDiagramDataModel extends DiagramDataModel<XmlDocument> {
    private static final java.lang.String ID_ATTRIBUTE = "id";
    private static final java.lang.String TO_ATTRIBUTE = "to";
    private static final java.lang.String NAME_ATTRIBUTE = "name";
    private Map<String, ProcessNode> nodes;
    private Collection<ProcessTransition> edges;

    public YDiagramDataModel(final Project project,final DiagramProvider<XmlDocument> provider, final XmlDocument document) {
        super(project, provider);

        nodes = getNodes(document);
        edges = getTransitions(document);
    }

    @NotNull
    @Override
    public Collection<? extends DiagramNode<XmlDocument>> getNodes() {
        return nodes.values();
    }

    @NotNull
    @Override
    public Collection<? extends DiagramEdge<XmlDocument>> getEdges() {
        return null;
    }

    @NotNull
    @Override
    public String getNodeName(DiagramNode<XmlDocument> diagramNode) {
        return null;
    }

    @Nullable
    @Override
    public DiagramNode<XmlDocument> addElement(XmlDocument xmlDocument) {
        return null;
    }

    @Override
    public void refreshDataModel() {

    }

    @NotNull
    @Override
    public ModificationTracker getModificationTracker() {
        return null;
    }

    @Override
    public void dispose() {

    }


    private Collection<ProcessTransition> getTransitions(XmlDocument document) {
        final Collection<ProcessTransition> result = new ArrayList<ProcessTransition>();

        for(final ProcessNode node : nodes.values()){
            for(final XmlTag transition : node.getTag().getSubTags()){
                final String targetNodeName = transition.getAttributeValue(TO_ATTRIBUTE);
                final ProcessNode destNode = nodes.get(targetNodeName);

                result.add(new ProcessTransition(node, destNode, new DiagramRelationshipInfoAdapter(transition.getAttributeValue(NAME_ATTRIBUTE), DiagramLineType.SOLID) {
                    @Override
                    public Shape getStartArrow() {
                        return STANDARD;
                    }
                }, transition));
            }
        }

        return result;
    }

    private Map<String, ProcessNode> getNodes(XmlDocument document) {
        final Map<String, ProcessNode> result = new HashMap<String, ProcessNode>();
        final XmlTag processTag = document.getRootTag();
        for(final XmlTag node : processTag.getSubTags()){
            result.put(node.getAttributeValue(ID_ATTRIBUTE), new ProcessNode(getProvider(), node));
        }

        return result;
    }
}
