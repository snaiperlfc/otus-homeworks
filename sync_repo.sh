#!/bin/sh
mkdir -p repo
cd repo
helm package ../otus-chart/*
helm repo index .
