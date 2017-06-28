package ru.igrey.ruleset;

import net.sourceforge.pmd.lang.java.ast.*;
import net.sourceforge.pmd.lang.java.rule.comments.AbstractCommentRule;
import net.sourceforge.pmd.lang.rule.properties.EnumeratedProperty;

import java.util.Arrays;
import java.util.List;

import static ru.igrey.ruleset.CommentRequiredRuleIgnoreCtors.CommentRequirement.*;

/**
 * Created by vkoba on 19.01.2017.
 */
public class CommentRequiredRuleIgnoreCtors extends AbstractCommentRule {
    public CommentRequiredRuleIgnoreCtors() {
        definePropertyDescriptor(HEADER_CMT_REQUIREMENT_DESCRIPTOR);
        definePropertyDescriptor(FIELD_CMT_REQUIREMENT_DESCRIPTOR);
        definePropertyDescriptor(PUB_METHOD_CMT_REQUIREMENT_DESCRIPTOR);
        definePropertyDescriptor(PROT_METHOD_CMT_REQUIREMENT_DESCRIPTOR);
        definePropertyDescriptor(ENUM_CMT_REQUIREMENT_DESCRIPTOR);
        definePropertyDescriptor(SERIAL_VERSION_UID_CMT_REQUIREMENT_DESCRIPTOR);
    }

    private CommentRequirement getCommentRequirement(String label) {
        if (CommentRequirement.Ignored.label.equals(label)) {
            return CommentRequirement.Ignored;
        } else if (CommentRequirement.Required.label.equals(label)) {
            return CommentRequirement.Required;
        } else if (CommentRequirement.Unwanted.label.equals(label)) {
            return CommentRequirement.Unwanted;
        } else {
            return null;
        }
    }

    @Override
    public Object visit(ASTClassOrInterfaceDeclaration decl, Object data) {

        CommentRequirement headerRequirement = getCommentRequirement(
                getProperty(HEADER_CMT_REQUIREMENT_DESCRIPTOR).toString());

        if (headerRequirement != CommentRequirement.Ignored) {
            if (headerRequirement == CommentRequirement.Required) {
                if (decl.comment() == null) {
                    addViolationWithMessage(data, decl,
                            HEADER_CMT_REQUIREMENT_DESCRIPTOR.name() + " " + CommentRequirement.Required,
                            decl.getBeginLine(), decl.getEndLine());
                }
            } else {
                if (decl.comment() != null) {
                    addViolationWithMessage(data, decl,
                            HEADER_CMT_REQUIREMENT_DESCRIPTOR.name() + " " + CommentRequirement.Unwanted,
                            decl.getBeginLine(), decl.getEndLine());
                }
            }
        }
        return super.visit(decl, data);
    }

    @Override
    public Object visit(ASTClassOrInterfaceBodyDeclaration decl, Object data) {
        if (!hasOverrideAnnotation(decl)) {
            if (!decl.findChildrenOfType(ASTMethodDeclaration.class).isEmpty()) {
                checkComment(decl.findChildrenOfType(ASTMethodDeclaration.class).get(0), data);
            }
        }
        return super.visit(decl, data);
    }

    private boolean hasOverrideAnnotation(ASTClassOrInterfaceBodyDeclaration decl) {
        List<ASTName> annotationNames = decl.findDescendantsOfType(ASTName.class);
        for (ASTName name : annotationNames) {
            if (name.getImage().equals("Override")) {
                return true;
            }
//            Node annotationTypeNode = annotation.jjtGetChild(0);
//            TypeNode annotationType = (TypeNode) annotationTypeNode;
//            if (annotationType.getType() == null) {
//                ASTName name = annotationTypeNode.getFirstChildOfType(ASTName.class);
//                if (name != null && name.getImage().equals("Override")) {
//                    return true;
//                }
//            } else if (annotationType.getType().equals(Override.class)) {
//                return true;
//            }
        }
        return false;
    }

    private void checkComment(AbstractJavaAccessNode decl, Object data) {
        CommentRequirement pubMethodRequirement = getCommentRequirement(
                getProperty(PUB_METHOD_CMT_REQUIREMENT_DESCRIPTOR).toString());
        CommentRequirement protMethodRequirement = getCommentRequirement(
                getProperty(PROT_METHOD_CMT_REQUIREMENT_DESCRIPTOR).toString());

        if (decl.isPublic()) {
            if (pubMethodRequirement != CommentRequirement.Ignored) {
                if (pubMethodRequirement == CommentRequirement.Required) {
                    if (decl.comment() == null) {
                        addViolationWithMessage(data, decl,
                                PUB_METHOD_CMT_REQUIREMENT_DESCRIPTOR.name() + " " + CommentRequirement.Required,
                                decl.getBeginLine(), decl.getEndLine());
                    }
                } else {
                    if (decl.comment() != null) {
                        addViolationWithMessage(data, decl,
                                PUB_METHOD_CMT_REQUIREMENT_DESCRIPTOR.name() + " " + CommentRequirement.Unwanted,
                                decl.getBeginLine(), decl.getEndLine());
                    }
                }
            }
        } else if (decl.isProtected()) {
            if (protMethodRequirement != CommentRequirement.Ignored) {
                if (protMethodRequirement == CommentRequirement.Required) {
                    if (decl.comment() == null) {
                        addViolationWithMessage(data, decl,
                                PROT_METHOD_CMT_REQUIREMENT_DESCRIPTOR.name() + " " + CommentRequirement.Required,
                                decl.getBeginLine(), decl.getEndLine());
                    }
                } else {
                    if (decl.comment() != null) {
                        addViolationWithMessage(data, decl,
                                PROT_METHOD_CMT_REQUIREMENT_DESCRIPTOR.name() + " " + CommentRequirement.Unwanted,
                                decl.getBeginLine(), decl.getEndLine());
                    }
                }
            }
        }
    }

    @Override
    public Object visit(ASTFieldDeclaration decl, Object data) {
        CommentRequirement fieldRequirement = getCommentRequirement(
                getProperty(FIELD_CMT_REQUIREMENT_DESCRIPTOR).toString());

        if (fieldRequirement != CommentRequirement.Ignored) {
            if (isSerialVersionUID(decl)) {
                checkSerialVersionUID(decl, data, fieldRequirement);
            } else if (fieldRequirement == CommentRequirement.Required) {
                if (decl.comment() == null) {
                    addViolationWithMessage(data, decl,
                            FIELD_CMT_REQUIREMENT_DESCRIPTOR.name() + " " + CommentRequirement.Required,
                            decl.getBeginLine(), decl.getEndLine());
                }
            } else {
                if (decl.comment() != null) {
                    addViolationWithMessage(data, decl,
                            FIELD_CMT_REQUIREMENT_DESCRIPTOR.name() + " " + CommentRequirement.Unwanted,
                            decl.getBeginLine(), decl.getEndLine());
                }
            }
        }

        return super.visit(decl, data);
    }

    private void checkSerialVersionUID(ASTFieldDeclaration decl, Object data, CommentRequirement fieldRequirement) {
        CommentRequirement serialVersionUIDReq = getCommentRequirement(
                getProperty(SERIAL_VERSION_UID_CMT_REQUIREMENT_DESCRIPTOR).toString());
        if (serialVersionUIDReq != CommentRequirement.Ignored) {
            if (fieldRequirement == CommentRequirement.Required) {
                if (decl.comment() == null) {
                    addViolationWithMessage(data, decl,
                            SERIAL_VERSION_UID_CMT_REQUIREMENT_DESCRIPTOR.name() + " " + CommentRequirement.Required,
                            decl.getBeginLine(), decl.getEndLine());
                }
            } else {
                if (decl.comment() != null) {
                    addViolationWithMessage(data, decl,
                            SERIAL_VERSION_UID_CMT_REQUIREMENT_DESCRIPTOR.name() + " " + CommentRequirement.Unwanted,
                            decl.getBeginLine(), decl.getEndLine());
                }
            }
        }
    }

    private boolean isSerialVersionUID(ASTFieldDeclaration field) {
        if ("serialVersionUID".equals(field.getVariableName()) && field.isStatic() && field.isFinal()
                && field.getType() == long.class) {
            return true;
        }
        return false;
    }

    @Override
    public Object visit(ASTEnumDeclaration decl, Object data) {
        CommentRequirement enumRequirement = getCommentRequirement(
                getProperty(ENUM_CMT_REQUIREMENT_DESCRIPTOR).toString());

        if (enumRequirement != CommentRequirement.Ignored) {
            if (enumRequirement == CommentRequirement.Required) {
                if (decl.comment() == null) {
                    addViolationWithMessage(data, decl,
                            ENUM_CMT_REQUIREMENT_DESCRIPTOR.name() + " " + CommentRequirement.Required,
                            decl.getBeginLine(), decl.getEndLine());
                }
            } else {
                if (decl.comment() != null) {
                    addViolationWithMessage(data, decl,
                            ENUM_CMT_REQUIREMENT_DESCRIPTOR.name() + " " + CommentRequirement.Unwanted,
                            decl.getBeginLine(), decl.getEndLine());
                }
            }
        }
        return super.visit(decl, data);
    }

    @Override
    public Object visit(ASTCompilationUnit cUnit, Object data) {
        assignCommentsToDeclarations(cUnit);

        return super.visit(cUnit, data);
    }

    public boolean allCommentsAreIgnored() {

        return getProperty(HEADER_CMT_REQUIREMENT_DESCRIPTOR) == CommentRequirement.Ignored
                && getProperty(FIELD_CMT_REQUIREMENT_DESCRIPTOR) == CommentRequirement.Ignored
                && getProperty(PUB_METHOD_CMT_REQUIREMENT_DESCRIPTOR) == CommentRequirement.Ignored
                && getProperty(PROT_METHOD_CMT_REQUIREMENT_DESCRIPTOR) == CommentRequirement.Ignored
                && getProperty(SERIAL_VERSION_UID_CMT_REQUIREMENT_DESCRIPTOR) == CommentRequirement.Ignored;
    }

    /**
     * 266      * @see PropertySource#dysfunctionReason()
     * 267
     */
    @Override
    public String dysfunctionReason() {
        return allCommentsAreIgnored() ? "All comment types are ignored" : null;
    }

    enum CommentRequirement {
        Required("Required"), Ignored("Ignored"), Unwanted("Unwanted");

        public static final EnumeratedProperty<CommentRequirement> HEADER_CMT_REQUIREMENT_DESCRIPTOR = new EnumeratedProperty<>(
                "headerCommentRequirement",
                "Header comments. Possible values: " + Arrays.toString(CommentRequirement.values()),
                CommentRequirement.labels(), CommentRequirement.values(), 0, 1.0f);
        public static final EnumeratedProperty<CommentRequirement> FIELD_CMT_REQUIREMENT_DESCRIPTOR = new EnumeratedProperty<>(
                "fieldCommentRequirement",
                "Field comments. Possible values: " + Arrays.toString(CommentRequirement.values()),
                CommentRequirement.labels(), CommentRequirement.values(), 0, 2.0f);
        public static final EnumeratedProperty<CommentRequirement> PUB_METHOD_CMT_REQUIREMENT_DESCRIPTOR = new EnumeratedProperty<>(
                "publicMethodCommentRequirement",
                "Public method and constructor comments. Possible values: " + Arrays.toString(CommentRequirement.values()),
                CommentRequirement.labels(), CommentRequirement.values(), 0, 3.0f);
        public static final EnumeratedProperty<CommentRequirement> PROT_METHOD_CMT_REQUIREMENT_DESCRIPTOR = new EnumeratedProperty<>(
                "protectedMethodCommentRequirement",
                "Protected method constructor comments. Possible values: " + Arrays.toString(CommentRequirement.values()),
                CommentRequirement.labels(), CommentRequirement.values(), 0, 4.0f);
        public static final EnumeratedProperty<CommentRequirement> ENUM_CMT_REQUIREMENT_DESCRIPTOR = new EnumeratedProperty<>(
                "enumCommentRequirement", "Enum comments. Possible values: " + Arrays.toString(CommentRequirement.values()),
                CommentRequirement.labels(), CommentRequirement.values(), 0, 5.0f);
        public static final EnumeratedProperty<CommentRequirement> SERIAL_VERSION_UID_CMT_REQUIREMENT_DESCRIPTOR = new EnumeratedProperty<CommentRequirement>(
                "serialVersionUIDCommentRequired",
                "serial version UID commts. Possible values: " + Arrays.toString(CommentRequirement.values()),
                CommentRequirement.labels(), CommentRequirement.values(), 1, 6.0f);
        private final String label;

        CommentRequirement(String theLabel) {
            label = theLabel;
        }

        public static String[] labels() {
            String[] labels = new String[values().length];
            int i = 0;
            for (CommentRequirement requirement : values()) {
                labels[i++] = requirement.label;
            }
            return labels;
        }
    }

}
