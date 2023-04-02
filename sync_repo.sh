#!/bin/sh
helm package otus-chart/*
helm repo index .
