/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

// This file was generated automatically. See compiler/fir/tree/tree-generator/Readme.md.
// DO NOT MODIFY IT MANUALLY.

package org.jetbrains.kotlin.fir.visitors

import org.jetbrains.kotlin.fir.FirTargetElement
import org.jetbrains.kotlin.fir.contracts.FirEffectDeclaration
import org.jetbrains.kotlin.fir.contracts.FirLegacyRawContractDescription
import org.jetbrains.kotlin.fir.contracts.FirRawContractDescription
import org.jetbrains.kotlin.fir.contracts.FirResolvedContractDescription
import org.jetbrains.kotlin.fir.declarations.*
import org.jetbrains.kotlin.fir.expressions.*
import org.jetbrains.kotlin.fir.references.*
import org.jetbrains.kotlin.fir.types.*

/**
 * Auto-generated by [org.jetbrains.kotlin.fir.tree.generator.printer.DefaultVisitorVoidPrinter]
 */
abstract class FirDefaultVisitorVoid : FirVisitorVoid() {
    override fun visitTypeRef(typeRef: FirTypeRef) = visitAnnotationContainer(typeRef)

    override fun visitResolvedDeclarationStatus(resolvedDeclarationStatus: FirResolvedDeclarationStatus) = visitDeclarationStatus(resolvedDeclarationStatus)

    override fun visitStatement(statement: FirStatement) = visitAnnotationContainer(statement)

    override fun visitExpression(expression: FirExpression) = visitStatement(expression)

    override fun visitLazyExpression(lazyExpression: FirLazyExpression) = visitExpression(lazyExpression)

    override fun visitTypeParametersOwner(typeParametersOwner: FirTypeParametersOwner) = visitTypeParameterRefsOwner(typeParametersOwner)

    override fun visitCallableDeclaration(callableDeclaration: FirCallableDeclaration) = visitMemberDeclaration(callableDeclaration)

    override fun visitConstructedClassTypeParameterRef(constructedClassTypeParameterRef: FirConstructedClassTypeParameterRef) = visitTypeParameterRef(constructedClassTypeParameterRef)

    override fun visitOuterClassTypeParameterRef(outerClassTypeParameterRef: FirOuterClassTypeParameterRef) = visitTypeParameterRef(outerClassTypeParameterRef)

    override fun visitReceiverParameter(receiverParameter: FirReceiverParameter) = visitAnnotationContainer(receiverParameter)

    override fun visitEnumEntry(enumEntry: FirEnumEntry) = visitVariable(enumEntry)

    override fun visitRegularClass(regularClass: FirRegularClass) = visitClass(regularClass)

    override fun visitCodeFragment(codeFragment: FirCodeFragment) = visitDeclaration(codeFragment)

    override fun visitAnonymousFunctionExpression(anonymousFunctionExpression: FirAnonymousFunctionExpression) = visitExpression(anonymousFunctionExpression)

    override fun visitAnonymousObject(anonymousObject: FirAnonymousObject) = visitClass(anonymousObject)

    override fun visitAnonymousObjectExpression(anonymousObjectExpression: FirAnonymousObjectExpression) = visitExpression(anonymousObjectExpression)

    override fun visitResolvedImport(resolvedImport: FirResolvedImport) = visitImport(resolvedImport)

    override fun visitDoWhileLoop(doWhileLoop: FirDoWhileLoop) = visitLoop(doWhileLoop)

    override fun visitWhileLoop(whileLoop: FirWhileLoop) = visitLoop(whileLoop)

    override fun visitBlock(block: FirBlock) = visitExpression(block)

    override fun visitLazyBlock(lazyBlock: FirLazyBlock) = visitBlock(lazyBlock)

    override fun visitBinaryLogicExpression(binaryLogicExpression: FirBinaryLogicExpression) = visitExpression(binaryLogicExpression)

    override fun <E : FirTargetElement> visitJump(jump: FirJump<E>) = visitExpression(jump)

    override fun visitLoopJump(loopJump: FirLoopJump) = visitJump(loopJump)

    override fun visitBreakExpression(breakExpression: FirBreakExpression) = visitLoopJump(breakExpression)

    override fun visitContinueExpression(continueExpression: FirContinueExpression) = visitLoopJump(continueExpression)

    override fun <T> visitLiteralExpression(literalExpression: FirLiteralExpression<T>) = visitExpression(literalExpression)

    override fun visitStarProjection(starProjection: FirStarProjection) = visitTypeProjection(starProjection)

    override fun visitPlaceholderProjection(placeholderProjection: FirPlaceholderProjection) = visitTypeProjection(placeholderProjection)

    override fun visitTypeProjectionWithVariance(typeProjectionWithVariance: FirTypeProjectionWithVariance) = visitTypeProjection(typeProjectionWithVariance)

    override fun visitCall(call: FirCall) = visitStatement(call)

    override fun visitAnnotation(annotation: FirAnnotation) = visitExpression(annotation)

    override fun visitComparisonExpression(comparisonExpression: FirComparisonExpression) = visitExpression(comparisonExpression)

    override fun visitAssignmentOperatorStatement(assignmentOperatorStatement: FirAssignmentOperatorStatement) = visitStatement(assignmentOperatorStatement)

    override fun visitIncrementDecrementExpression(incrementDecrementExpression: FirIncrementDecrementExpression) = visitExpression(incrementDecrementExpression)

    override fun visitAugmentedArraySetCall(augmentedArraySetCall: FirAugmentedArraySetCall) = visitStatement(augmentedArraySetCall)

    override fun visitClassReferenceExpression(classReferenceExpression: FirClassReferenceExpression) = visitExpression(classReferenceExpression)

    override fun visitPropertyAccessExpression(propertyAccessExpression: FirPropertyAccessExpression) = visitQualifiedAccessExpression(propertyAccessExpression)

    override fun visitIntegerLiteralOperatorCall(integerLiteralOperatorCall: FirIntegerLiteralOperatorCall) = visitFunctionCall(integerLiteralOperatorCall)

    override fun visitImplicitInvokeCall(implicitInvokeCall: FirImplicitInvokeCall) = visitFunctionCall(implicitInvokeCall)

    override fun visitMultiDelegatedConstructorCall(multiDelegatedConstructorCall: FirMultiDelegatedConstructorCall) = visitDelegatedConstructorCall(multiDelegatedConstructorCall)

    override fun visitComponentCall(componentCall: FirComponentCall) = visitFunctionCall(componentCall)

    override fun visitCallableReferenceAccess(callableReferenceAccess: FirCallableReferenceAccess) = visitQualifiedAccessExpression(callableReferenceAccess)

    override fun visitThisReceiverExpression(thisReceiverExpression: FirThisReceiverExpression) = visitQualifiedAccessExpression(thisReceiverExpression)

    override fun visitSmartCastExpression(smartCastExpression: FirSmartCastExpression) = visitExpression(smartCastExpression)

    override fun visitSafeCallExpression(safeCallExpression: FirSafeCallExpression) = visitExpression(safeCallExpression)

    override fun visitCheckedSafeCallSubject(checkedSafeCallSubject: FirCheckedSafeCallSubject) = visitExpression(checkedSafeCallSubject)

    override fun visitWrappedExpression(wrappedExpression: FirWrappedExpression) = visitExpression(wrappedExpression)

    override fun visitWrappedArgumentExpression(wrappedArgumentExpression: FirWrappedArgumentExpression) = visitWrappedExpression(wrappedArgumentExpression)

    override fun visitLambdaArgumentExpression(lambdaArgumentExpression: FirLambdaArgumentExpression) = visitWrappedArgumentExpression(lambdaArgumentExpression)

    override fun visitSpreadArgumentExpression(spreadArgumentExpression: FirSpreadArgumentExpression) = visitWrappedArgumentExpression(spreadArgumentExpression)

    override fun visitNamedArgumentExpression(namedArgumentExpression: FirNamedArgumentExpression) = visitWrappedArgumentExpression(namedArgumentExpression)

    override fun visitVarargArgumentsExpression(varargArgumentsExpression: FirVarargArgumentsExpression) = visitExpression(varargArgumentsExpression)

    override fun visitSamConversionExpression(samConversionExpression: FirSamConversionExpression) = visitExpression(samConversionExpression)

    override fun visitResolvedQualifier(resolvedQualifier: FirResolvedQualifier) = visitExpression(resolvedQualifier)

    override fun visitResolvedReifiedParameterReference(resolvedReifiedParameterReference: FirResolvedReifiedParameterReference) = visitExpression(resolvedReifiedParameterReference)

    override fun visitReturnExpression(returnExpression: FirReturnExpression) = visitJump(returnExpression)

    override fun visitThrowExpression(throwExpression: FirThrowExpression) = visitExpression(throwExpression)

    override fun visitVariableAssignment(variableAssignment: FirVariableAssignment) = visitStatement(variableAssignment)

    override fun visitWhenSubjectExpression(whenSubjectExpression: FirWhenSubjectExpression) = visitExpression(whenSubjectExpression)

    override fun visitDesugaredAssignmentValueReferenceExpression(desugaredAssignmentValueReferenceExpression: FirDesugaredAssignmentValueReferenceExpression) = visitExpression(desugaredAssignmentValueReferenceExpression)

    override fun visitWrappedDelegateExpression(wrappedDelegateExpression: FirWrappedDelegateExpression) = visitWrappedExpression(wrappedDelegateExpression)

    override fun visitEnumEntryDeserializedAccessExpression(enumEntryDeserializedAccessExpression: FirEnumEntryDeserializedAccessExpression) = visitExpression(enumEntryDeserializedAccessExpression)

    override fun visitNamedReference(namedReference: FirNamedReference) = visitReference(namedReference)

    override fun visitNamedReferenceWithCandidateBase(namedReferenceWithCandidateBase: FirNamedReferenceWithCandidateBase) = visitNamedReference(namedReferenceWithCandidateBase)

    override fun visitFromMissingDependenciesNamedReference(fromMissingDependenciesNamedReference: FirFromMissingDependenciesNamedReference) = visitNamedReference(fromMissingDependenciesNamedReference)

    override fun visitSuperReference(superReference: FirSuperReference) = visitReference(superReference)

    override fun visitThisReference(thisReference: FirThisReference) = visitReference(thisReference)

    override fun visitControlFlowGraphReference(controlFlowGraphReference: FirControlFlowGraphReference) = visitReference(controlFlowGraphReference)

    override fun visitResolvedNamedReference(resolvedNamedReference: FirResolvedNamedReference) = visitNamedReference(resolvedNamedReference)

    override fun visitResolvedErrorReference(resolvedErrorReference: FirResolvedErrorReference) = visitResolvedNamedReference(resolvedErrorReference)

    override fun visitDelegateFieldReference(delegateFieldReference: FirDelegateFieldReference) = visitResolvedNamedReference(delegateFieldReference)

    override fun visitBackingFieldReference(backingFieldReference: FirBackingFieldReference) = visitResolvedNamedReference(backingFieldReference)

    override fun visitResolvedCallableReference(resolvedCallableReference: FirResolvedCallableReference) = visitResolvedNamedReference(resolvedCallableReference)

    override fun visitResolvedTypeRef(resolvedTypeRef: FirResolvedTypeRef) = visitTypeRef(resolvedTypeRef)

    override fun visitTypeRefWithNullability(typeRefWithNullability: FirTypeRefWithNullability) = visitTypeRef(typeRefWithNullability)

    override fun visitUserTypeRef(userTypeRef: FirUserTypeRef) = visitTypeRefWithNullability(userTypeRef)

    override fun visitDynamicTypeRef(dynamicTypeRef: FirDynamicTypeRef) = visitTypeRefWithNullability(dynamicTypeRef)

    override fun visitFunctionTypeRef(functionTypeRef: FirFunctionTypeRef) = visitTypeRefWithNullability(functionTypeRef)

    override fun visitIntersectionTypeRef(intersectionTypeRef: FirIntersectionTypeRef) = visitTypeRefWithNullability(intersectionTypeRef)

    override fun visitImplicitTypeRef(implicitTypeRef: FirImplicitTypeRef) = visitTypeRef(implicitTypeRef)

    override fun visitEffectDeclaration(effectDeclaration: FirEffectDeclaration) = visitContractElementDeclaration(effectDeclaration)

    override fun visitLegacyRawContractDescription(legacyRawContractDescription: FirLegacyRawContractDescription) = visitContractDescription(legacyRawContractDescription)

    override fun visitRawContractDescription(rawContractDescription: FirRawContractDescription) = visitContractDescription(rawContractDescription)

    override fun visitResolvedContractDescription(resolvedContractDescription: FirResolvedContractDescription) = visitContractDescription(resolvedContractDescription)

}
