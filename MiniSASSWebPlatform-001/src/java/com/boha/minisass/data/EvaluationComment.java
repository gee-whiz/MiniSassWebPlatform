/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.boha.minisass.data;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author aubreyM
 */
@Entity
@Table(name = "evaluationComment")
@NamedQueries({
    @NamedQuery(name = "EvaluationComment.findAll", query = "SELECT e FROM EvaluationComment e"),
    @NamedQuery(name = "EvaluationComment.findByEvaluationCommentID", query = "SELECT e FROM EvaluationComment e WHERE e.evaluationCommentID = :evaluationCommentID")})
public class EvaluationComment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "evaluationCommentID")
    private Integer evaluationCommentID;
    @JoinColumn(name = "evaluationID", referencedColumnName = "evaluationID")
    @ManyToOne(optional = false)
    private Evaluation evaluation;
    @JoinColumn(name = "commentID", referencedColumnName = "commentID")
    @ManyToOne(optional = false)
    private Comment comment;

    public EvaluationComment() {
    }

    public EvaluationComment(Integer evaluationCommentID) {
        this.evaluationCommentID = evaluationCommentID;
    }

    public Integer getEvaluationCommentID() {
        return evaluationCommentID;
    }

    public void setEvaluationCommentID(Integer evaluationCommentID) {
        this.evaluationCommentID = evaluationCommentID;
    }

    public Evaluation getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(Evaluation evaluation) {
        this.evaluation = evaluation;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (evaluationCommentID != null ? evaluationCommentID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvaluationComment)) {
            return false;
        }
        EvaluationComment other = (EvaluationComment) object;
        if ((this.evaluationCommentID == null && other.evaluationCommentID != null) || (this.evaluationCommentID != null && !this.evaluationCommentID.equals(other.evaluationCommentID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.boha.minisass.data.EvaluationComment[ evaluationCommentID=" + evaluationCommentID + " ]";
    }
    
}
