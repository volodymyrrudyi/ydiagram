package com.rvcode.ydiagram;

import com.intellij.diagram.DiagramVfsResolver;
import com.intellij.ide.highlighter.XmlFileType;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.xml.XmlDocument;
import com.intellij.psi.xml.XmlFile;
import org.jetbrains.annotations.Nullable;

import java.io.File;

public class YDiagramResolver implements DiagramVfsResolver<XmlDocument>{

    @Override
    public String getQualifiedName(XmlDocument xmlDocument) {
        return xmlDocument.getContainingFile().getName();
    }

    @Nullable
    @Override
    public XmlDocument resolveElementByFQN(String path, Project project) {
        final VirtualFile file =  LocalFileSystem.getInstance().findFileByIoFile(new File(path));

        if (file.getFileType().equals(XmlFileType.INSTANCE)){
            final XmlFile xml = (XmlFile) PsiManager.getInstance(project).findFile(file);
            return xml.getDocument();
        } else {
            return null;
        }
    }
}
